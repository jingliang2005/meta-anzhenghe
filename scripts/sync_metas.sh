#!/bin/bash

set -e

echo "snyc meta layer"

echo $PWD
cd ../../
echo $PWD

function cloneOrPull {
    if [ ! -d "$2" ]
    then
        git clone $1 $2 -b dunfell --depth 1
    else
        git -C $2 clean -dfx
        git -C $2 reset --hard
        git -C $2 pull
    fi
} 

cloneOrPull git://git.yoctoproject.org/meta-freescale meta-freescale
 cloneOrPull  git://github.com/beagleboard/meta-beagleboard meta-beagleboard
 cloneOrPull  https://github.com/meta-qt5/meta-qt5.git  meta-qt5
 cloneOrPull  git://git.yoctoproject.org/meta-raspberrypi meta-raspberry
 cloneOrPull  https://github.com/kraj/meta-altera.git meta-altera
 cloneOrPull  git://git.yoctoproject.org/meta-ti meta-ti
  cloneOrPull  git://git.yoctoproject.org/meta-arm meta-arm
  cloneOrPull  git@github.com:openembedded/meta-openembedded.git meta-openembedded
 