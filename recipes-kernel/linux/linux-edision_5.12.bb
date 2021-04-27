require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "coreutils-native"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v5.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	file://findkerneldevice.py \
	"

COMPATIBLE_MACHINE = "osmini4k|osmio4k|osmio4kplus"

SRC_URI[kernel.md5sum] = "8c7420990de85f6754db287337da08b4"
SRC_URI[kernel.sha256sum] = "7d0df6f2bf2384d68d0bd8e1fe3e071d64364dcdc6002e7b5c87c92d48fac366"
SRC_URI[kernelpatch.md5sum] = "7d0905b090a8862d1be7737daee880b2"
SRC_URI[kernelpatch.sha256sum] = "0240577ed00dc583cef23f88262d58ed701637862e3a8624e99de25fa3866261"

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
