SUMMARY = "Driver for Realtek 8723BS wireless/bluetooth devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

PR = "r0"

SRC_URI = "git://github.com/22ktv/rtl8723bs.git"
SRCREV = "0fb78de6be7332b4fa8998aa6163118c7cf9f9d4"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/staging/rtl8723bs
	install -m 0644 ${S}/r8723bs.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/staging/rtl8723bs
}

inherit gitpkgv

python do_package_prepend() {
    d.setVar('PKGV', ''.join([d.getVar("KERNEL_VERSION", True).split("-")[0], '+', 'git${GITPKGV}']))
}
