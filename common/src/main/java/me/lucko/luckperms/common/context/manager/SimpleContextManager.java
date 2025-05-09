/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.common.context.manager;

import com.github.benmanes.caffeine.cache.LoadingCache;
import me.lucko.luckperms.common.plugin.LuckPermsPlugin;
import me.lucko.luckperms.common.util.CaffeineFactory;
import net.luckperms.api.query.QueryOptions;

import java.util.concurrent.TimeUnit;

public abstract class SimpleContextManager<S, P extends S> extends ContextManager<S, P> {

    private final LoadingCache<S, QueryOptions> contextsCache = CaffeineFactory.newBuilder()
            .expireAfterWrite(50, TimeUnit.MILLISECONDS)
            .build(this::calculate);

    protected SimpleContextManager(LuckPermsPlugin plugin, Class<S> subjectClass, Class<P> playerClass) {
        super(plugin, subjectClass, playerClass);
    }

    @Override
    public QueryOptions getQueryOptions(S subject) {
        return this.contextsCache.get(subject);
    }

    @Override
    public void invalidateCache(S subject) {
        this.contextsCache.invalidate(subject);
    }
}
