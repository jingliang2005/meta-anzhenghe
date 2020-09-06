SUMMARY = "A PyQt5 development image"

require azh-qt5-image.bb

QT5_PKGS += " \
    python3-pyqt5 \
    pytouch \
"

export IMAGE_BASENAME = "py3qt-image"
