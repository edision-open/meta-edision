require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	file://findkerneldevice.py \
	"

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[kernel.md5sum] = "d39dd4ba2d5861c54b90d49be19eaf31"
SRC_URI[kernel.sha256sum] = "ad0823183522e743972382df0aa08fb5ae3077f662b125f1e599b0b2aaa12438"
SRC_URI[kernelpatch.md5sum] = "81573e0c332d503fe864292c1aac096d"
SRC_URI[kernelpatch.sha256sum] = "e2e63ca7f43c07073b51059127df128a83b6fe79ed0620e740796dedd829e706"

FILES_kernel-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}* ${KERNEL_IMAGEDEST}/findkerneldevice.py"

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
