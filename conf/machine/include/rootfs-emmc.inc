IMAGE_CLASSES += "osmio4k-emmcimg"
IMAGE_FSTYPES ?= "emmcimg tar.bz2"
IMAGE_OVERHEAD_FACTOR = "1.0"

IMAGEDIR ?= "${MACHINE}"
IMGDEPLOYDIR ?= "${DEPLOY_DIR_IMAGE}"
IMAGEVERSION := "${DISTRO_NAME}-${DISTRO_VERSION}-${DATE}"
IMAGEVERSION[vardepsexclude] = "DATE"

IMAGE_CMD_emmcimg_append = "\
    mkdir -p ${IMGDEPLOYDIR}/${IMAGEDIR}; \
    cp -f ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.emmc ${IMGDEPLOYDIR}/${IMAGEDIR}/emmc.img; \
    cp -f ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin ${IMGDEPLOYDIR}/${IMAGEDIR}/kernel.bin; \
    cp -f ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.tar.bz2 ${IMGDEPLOYDIR}/${IMAGEDIR}/rootfs.tar.bz2; \
    cp -f ${DEPLOY_DIR_IMAGE}/splash.bin ${IMGDEPLOYDIR}/${IMAGEDIR}; \
    echo "${IMAGEVERSION}" > ${IMGDEPLOYDIR}/${IMAGEDIR}/imageversion; \
    echo "rename this file to 'force' to force an update without confirmation" > ${IMGDEPLOYDIR}/${IMAGEDIR}/noforce; \
    cd ${IMGDEPLOYDIR}; \
    zip ${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}_usb.zip ${IMAGEDIR}/emmc.img ${IMAGEDIR}/imageversion ${IMAGEDIR}/noforce ${IMAGEDIR}/splash.bin ; \
    zip ${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}_multiboot_ofgwrite.zip ${IMAGEDIR}/imageversion ${IMAGEDIR}/kernel.bin ${IMAGEDIR}/rootfs.tar.bz2; \
    rm -rf ${IMAGEDIR}; \
    "
