SUMMARY = "Driver for Realtek 8723BS wireless/bluetooth devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

PV = "5.0"
PR = "r0"

RDEPENDS_${PN} = "kernel-module-r8723bs firmware-rtl8723bs"

ALLOW_EMPTY_${PN} = "1"
