
# LowbitPerms

LowBitPerms is a permission plugin fork  of LuckPerms

It can be build, but there is no documentation (Might wanna check that out later)

It is:

* **fast** - written with performance and scalability in mind.
* **reliable** - trusted by thousands of server admins, and the largest of server networks.
* **easy to use** - setup permissions using commands, directly in config files, or using the web editor.
* **flexible** - supports a variety of data storage options, and works on lots of different server types.
* **extensive** - a plethora of customization options and settings which can be changed to suit your server.
* **free** - available for download and usage at no cost, and permissively licensed so it can remain free forever.


## Building
LowBitPerms uses Gradle to handle dependencies & building.

#### Requirements
* Java 21 JDK or newer
* Git

#### Compiling from source
```sh
git clone https://github.com/LowBitPerms/LowBitPerms.git
cd LowBitPerms/
./gradlew build
```

You can find the output jars in the `loader/build/libs` or `build/libs` directories.

## Tests
There are some automated tests which run during each build.

## Contributing
#### Pull Requests
If you make any changes or improvements to the plugin which you think would be beneficial to others, please consider making a pull request to merge your changes back into the upstream project. (especially if your changes are bug fixes!)

LuckPerms loosely follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html). Generally, try to copy the style of code found in the class you're editing. 

#### Project Layout
The project is split up into a few separate modules.

* **API** - The public, semantically versioned API used by other plugins wishing to integrate with and retrieve data from LuckPerms. This module (for the most part) does not contain any implementation itself, and is provided by the plugin.
* **Common** - The common module contains most of the code which implements the respective LuckPerms plugins. This abstract module reduces duplicated code throughout the project.
* **Bukkit, BungeeCord, Fabric, Forge, Nukkit, Sponge & Velocity** - Each use the common module to implement plugins on the respective server platforms.

## License
LowBitPerms is licensed under the permissive MIT license. Please see [`LICENSE.txt`](https://github.com/LuckPerms/LuckPerms/blob/master/LICENSE.txt) for more info.
