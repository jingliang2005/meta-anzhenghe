SUMMARY = "Qt5 app for checking display colors"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase qtserialport qtmultimedia qtvirtualkeyboard"

SRCREV = "3ed18f1182eb0eb153b5202a82789b14367271ce"
SRC_URI = "git:///nfsroot/sixaxis/.git" 


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/sixaxis ${D}${bindir}
}

FILES_${PN} = "${bindir}"

RDEPENDS_${PN} = "qtbase-plugins"

