SUMMARY = "Driver for Realtek 8723BS wireless/bluetooth devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

inherit gitpkgv

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/22ktv/rtl8723bs.git"

inherit module machine_kernel_pr

S = "${WORKDIR}/git"

MACHINE_KERNEL_PR_append = "r0"

EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/staging/rtl8723bs
	install -m 0644 ${S}/r8723bs.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/staging/rtl8723bs
}
