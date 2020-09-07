#!/bin/bash

set -e

echo "snyc meta layer"

echo $PWD
cd ../../
echo $PWD

function cloneOrPull {
    if [ ! -d "$2" ]
    then
        git clone $1 $2 -b $3 --depth 1
    else
        git -C $2 clean -dfx
        git -C $2 reset --hard
        git -C $2 pull
    fi
} 

BRANCH="dunfell"
cloneOrPull  git://git.yoctoproject.org/meta-freescale meta-freescale $BRANCH
cloneOrPull  git://github.com/beagleboard/meta-beagleboard meta-beagleboard master
cloneOrPull  https://github.com/meta-qt5/meta-qt5.git  meta-qt5 $BRANCH
cloneOrPull  git://git.yoctoproject.org/meta-raspberrypi meta-raspberry $BRANCH
cloneOrPull  https://github.com/kraj/meta-altera.git meta-altera master
cloneOrPull  git://git.yoctoproject.org/meta-ti meta-ti $BRANCH
cloneOrPull  git://git.yoctoproject.org/meta-arm meta-arm $BRANCH
cloneOrPull  git@github.com:openembedded/meta-openembedded.git meta-openembedded $BRANCH
 
