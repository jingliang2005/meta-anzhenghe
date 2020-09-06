# meta-anzhenghe
A Yocto meta layer,

#列出支持的图像 
ls meta*/recipes*/images/*.bb

# 运行单独的任务，-c  -f:强制执行。
$ bitbake matchbox-desktop
     [make some changes to the source code in the 
     
     
     
     ]
     $ bitbake matchbox-desktop -c compile -f
     $ bitbake matchbox-desktop

     依赖图
bitbake -g targetname命令在当前目录中创建depends.dot和 task-depends.dot文件。bitbake -g -u depexp targetname命令以更易于理解的形式显示结果。

如果要删除psplash引导启动屏幕，请在内核命令行中添加“ psplash = false”。这样做可以防止psplash加载，从而使您可以看到控制台。通过切换虚拟控制台（例如Zaurus上的Fn + Left或Fn + Right），也可以切换出初始屏幕。

# 清除任务
bitbake -c clean task-boot task-base task-poky
 bitbake poky-image-sato

 ＃ SSH服务
 Poky附带有两个可以在映像中使用的SSH服务器：Dropbear和OpenSSH。Dropbear是适合资源受限环境的最小SSH服务器，而OpenSSH是众所周知的标准SSH服务器实现。默认情况下，poky-image-sato配置为使用Dropbear。poky-image-basic和poky-image-lsb映像都包含OpenSSH。要更改这些默认值，请编辑IMAGE_FEATURES变量，以便将要使用的映像设置为包括ssh-server-dropbear或ssh-server-openssh。

＃自定义图像，共四种方法，建议用前面三种。
1 使用自定义.bb文件自定义图像
创建自定义图像，可以完全控制图像的内容。在IMAGE_INSTALL变量中使用正确的软件包名称很重要 。名称必须使用OpenEmbedded表示法，而不是Debian表示法（例如，“ glibc-dev”而不是“ libc6-dev”）。
创建自定义图像的另一种方法是修改现有图像
meta-anzhenghe/recipes-images/azh-base-image.bb

2 使用自定义任务自定义图像
复杂的自定义图像，最好的方法是创建用于构建一个或多个图像的自定义任务包。
任务包的一个很好的例子是 meta/recipes-sato/tasks/task-poky.bb。
对于添加的每个程序包，可以使用 RDEPENDS 和RRECOMMENDS 条目提供父任务程序包应包含的程序包列表。
#(查找不到tasks这样的文件夹  meta/recipes-sato/tasks/)


3 使用自定义IMAGE_FEATURES自定义图像
使用IMAGE_FEATURES 变量使用的额外图像“功能” 。要创建这些功能，最好的参考是 meta/classes/poky-image.bbclass，它显示了poky如何做到这一点。总而言之，该文件查看IMAGE_FEATURES 变量的内容， 然后将其映射到一组任务或程序包中。根据此信息，将自动生成IMAGE_INSTALL 变量。用户可以通过扩展类或创建用于特殊图像.bb文件的自定义类来添加其他功能。
mate-anzhenghe/classes/  (20020810从meta-qt5复制整个文件夹过来)

4 使用local.conf自定义图像



添加标准类型的软件包


交叉编译好的程序运行的时候只显示英文部分，中文是空的。把这个字体拷贝到开发板字体文件夹下
/usr/lib/fonts/
/usr/share/fonts/
代码中不用指定font，不用添加任何字体相关代码
开发板不用添加任何环境变量，yocto自己设置的环境变量就可以
只需要添加字体文件到这两个文件夹下就行


1、在yocto编译配置文件中添加默认环境是中文环境，使得在制作镜像的时候将编译好的中文环境包打进去；

2、在yocto编译配置文件中添加一个支持中文环境的packagegroups，之后在制作镜像的配置文件中添加该中文环境的packagegroups；

3、在已有的yocto安装镜像中添加中文环境安装包；
在yocto编译目录中能够找到安装包（：


还需要安装中文字体包，我用的中文字体是文泉译，
因此需要将文泉译字体复制到已有镜像的/usr/share/fonts/ttf/目录内，之后执行命令#fc-cache -fv来使能该中文字体。

最后一步需要配置环境变量LANG，export LANG=zh_CN.UTF-8
 

     

















