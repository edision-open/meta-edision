DESCRIPTION = "Hardware drivers for Edision OS mega"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osmega"

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
	install -m 0644 ${S}/brcmstb-osmega.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/ci.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/ftm4862.ko ${D}${base_libdir}/modules/${KV}/extra

	install -d ${D}${sysconfdir}/modules-load.d
	echo brcmstb-osmega >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo ci >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo ftm4862 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

SRC_URI[md5sum] = "67f0cda2b87c9ba1c51f1ad7281cb3bc"
SRC_URI[sha256sum] = "a43cb5f0c36933d151e446c26847c21d626bc9f63bd423c9c7ff3d72ba18b7e3"
