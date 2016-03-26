SUMMARY = "bluez-hcitools for Realtek 8723BS wireless/bluetooth devices"
HOMEPAGE = "http://www.realtek.com/"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/22ktv/bluez-hcitools.git"
SRCREV = "dbf12108890e016da9053d39186e77ec44ec803d"

inherit gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

S = "${WORKDIR}/git"

CFLAGS_append = " -I${S} -I${S}/lib"

do_install_append_osmini() {
	install -d ${D}${sbindir}
	install -m 0755 ${S}/hciattach ${D}${sbindir}/hciattach
}

RDEPENDS_${PN} = "firmware-rtl8723bs"
