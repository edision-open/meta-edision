DESCRIPTION = "Hardware drivers for Edision OS mini"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osmini"

KV = "4.8.0"
SRCDATE = "20161207"

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
	install -m 0644 ${S}/brcmstb-osmini.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/fts260.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/sp988x.ko ${D}${base_libdir}/modules/${KV}/extra

	install -d ${D}${sysconfdir}/modules-load.d
	echo brcmstb-osmini >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo fts260 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo sp988x >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

SRC_URI[md5sum] = "d1540d4c0537d2c77b76aa64c1cb540e"
SRC_URI[sha256sum] = "40bacabb3cfa764304d0e67a1d728b197715ce6233c01e5714f1b99032c90ef9"
