SUMMARY = "A basic Qt5 qwidgets dev image"

#require image
inherit core-image

IMAGE_LINGUAS = "zh-cn"

inherit populate_sdk_qt5
 
IMAGE_FEATURES += "dev-pkgs tools-sdk \
	tools-debug eclipse-debug tools-profile tools-testapps debug-tweaks ssh-server-openssh"

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
"

QT_TOOLS = " \
    qtbase \
    qt5-env \
    qtserialport \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

TSLIB = " \
    tslib \
    tslib-conf \
    tslib-calibrate \
    tslib-tests \
"

TEST_APPS += " \
    qcolorcheck-tools \
    tspress-tools \ 
    sixaxis \
"

IMAGE_INSTALL += " \
    ${FONTS} \
    ${QT_DEV_TOOLS} \
    ${QT_TOOLS} \
    ${TEST_APPS} \
    ${TSLIB} \
"

export IMAGE_BASENAME = "qt5-basic-image"
