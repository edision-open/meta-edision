DESCRIPTION = "Hardware drivers for Edision OS mini+"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osminiplus"

KV = "4.5.0"
SRCDATE = "20160503"

PV = "${KV}+${SRCDATE}"
PR = "r0"

RDEPENDS_${PN} += "firmware-mn8847x"

SRC_URI = "https://github.com/open-edision/os-dvb-modules/raw/master/linux-${KV}-${MACHINE}-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

do_compile() {
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/brcmstb-osminiplus.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/fts260.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/mn88473.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/ftm4862.ko ${D}${base_libdir}/modules/${KV}/extra

	install -d ${D}${sysconfdir}/modules-load.d
	echo brcmstb-osminiplus >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo fts260 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo mn88473 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo ftm4862 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

SRC_URI[md5sum] = "e68ef71d3a391c593f51566b48ad035f"
SRC_URI[sha256sum] = "9f343eb55c2ddb96da33d0d41a907b5b61ed36615feaef8bf84836dc0bae5694"
