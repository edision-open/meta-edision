DESCRIPTION = "Hardware drivers for Edision OS mini+"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osminiplus"

KV = "4.8.0"
SRCDATE = "20161122"

PV = "${KV}+${SRCDATE}"
PR = "r0"

RDEPENDS_${PN} += "firmware-mn8847x"

SRC_URI = "https://github.com/open-edision/os-dvb-modules/raw/master/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

do_compile() {
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/brcmstb-osminiplus.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/fts260.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/sp988x.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/ftm4862.ko ${D}${base_libdir}/modules/${KV}/extra

	install -d ${D}${sysconfdir}/modules-load.d
	echo brcmstb-osminiplus >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo fts260 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo sp988x >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo ftm4862 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

SRC_URI[md5sum] = "d3caa4ecf2a5d41eb67f17eef02b0822"
SRC_URI[sha256sum] = "535f3de66140d58811033b159cd0ae633ea058888ded812b05ff269fa95a7017"
