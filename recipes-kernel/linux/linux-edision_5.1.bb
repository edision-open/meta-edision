require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v5.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	file://findkerneldevice.py \
	"

COMPATIBLE_MACHINE = "osmio4k|osmio4kplus"

SRC_URI[kernel.md5sum] = "15fbdff95ff98483069ac6e215b9f4f9"
SRC_URI[kernel.sha256sum] = "d06a7be6e73f97d1350677ad3bae0ce7daecb79c2c2902aaabe806f7fa94f041"
SRC_URI[kernelpatch.md5sum] = "a35c9d0ec24522ca59613fc2543defec"
SRC_URI[kernelpatch.sha256sum] = "31795da29b9942fd51ebf659399343e178226b37a294232c649e4e0d34796ee4"

FILES_kernel-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}* ${KERNEL_IMAGEDEST}/findkerneldevice.py"

do_shared_workdir_append() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	make CC="${KERNEL_CC}" LD="${KERNEL_LD}" AR="${KERNEL_AR}" \
	           -C ${STAGING_KERNEL_DIR} O=${STAGING_KERNEL_BUILDDIR} scripts prepare
}

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
