DESCRIPTION = "Edision Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

INC_PR = "r0"

DEPENDS += "xz-native bc-native"
DEPENDS_append_aarch64 = " libgcc"
KERNEL_CC_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"
KERNEL_LD_append_aarch64 = " ${TOOLCHAIN_OPTIONS}"

KERNEL_EXTRA_ARGS = "EXTRA_CFLAGS=-Wno-attribute-alias"

# Pick up shared functions
inherit kernel

export OS = "Linux"

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

KERNEL_IMAGEDEST = "tmp"

FILES_kernel-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}*"

pkg_postinst_kernel-image () {
	if [ -z "$D" ]
	then
		MTD_DEVICE=$(grep 'kernel' /proc/mtd | cut -f1 -d':')
		flash_eraseall /dev/${MTD_DEVICE}
		nandwrite -p /dev/${MTD_DEVICE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
		rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	fi
}

pkg_postrm_kernel-image () {
}

do_rm_work() {
}
