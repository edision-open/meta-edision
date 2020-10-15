require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "coreutils-native"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v5.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	file://findkerneldevice.py \
	"

COMPATIBLE_MACHINE = "osmini4k|osmio4k|osmio4kplus"

SRC_URI[kernel.md5sum] = "0959d759fd19e146367221aff504ad91"
SRC_URI[kernel.sha256sum] = "3239a4ee1250bf2048be988cc8cb46c487b2c8a0de5b1b032d38394d5c6b1a06"
SRC_URI[kernelpatch.md5sum] = "cf4f56209906f912bce6dd4ae28f2336"
SRC_URI[kernelpatch.sha256sum] = "017be1b2333f75d86e05092f0cb50d37c4b5fe023798f8945a8ce2b95c3f98aa"

FILES_${KERNEL_PACKAGE_NAME}-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}* ${KERNEL_IMAGEDEST}/findkerneldevice.py"

kernel_do_install_append () {
	install -d ${D}/${KERNEL_IMAGEDEST}
	install -m 0644 ${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	install -m 0644 ${WORKDIR}/findkerneldevice.py ${D}/${KERNEL_IMAGEDEST}
}

pkg_postinst_kernel-image () {
	if [ -z "$D" ]
	then
		python /${KERNEL_IMAGEDEST}/findkerneldevice.py
		dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} of=/dev/kernel
	fi
}
