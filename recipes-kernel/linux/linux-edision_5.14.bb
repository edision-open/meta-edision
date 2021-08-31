require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "coreutils-native"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v5.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	file://findkerneldevice.py \
	"

COMPATIBLE_MACHINE = "osmini4k|osmio4k|osmio4kplus"

SRC_URI[kernel.md5sum] = "a082ef5748b813abca0649dab8be5f52"
SRC_URI[kernel.sha256sum] = "7e068b5e0d26a62b10e5320b25dce57588cbbc6f781c090442138c9c9c3271b2"
SRC_URI[kernelpatch.md5sum] = "f71fea6bc1873d8c6f146ce5b6b547ea"
SRC_URI[kernelpatch.sha256sum] = "03bc45019116086f120ebb539c2d9e9b9555e83c7bd1cd64f98eee369c29c8b4"

FILES_${KERNEL_PACKAGE_NAME}-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}* ${KERNEL_IMAGEDEST}/findkerneldevice.py"

do_compile_kernelmodules_append() {
	# openembedded-core 0fc66a0b64953aae38d0124b57615fffaec8de52
	if (grep -q -i -e '^CONFIG_MODULES=y$' ${B}/.config); then
		# 5.10+ kernels have module.lds that we need to copy for external module builds
		if [ -e "${B}/scripts/module.lds" ]; then
			install -Dm 0644 ${B}/scripts/module.lds ${STAGING_KERNEL_BUILDDIR}/scripts/module.lds
		fi
	fi
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
