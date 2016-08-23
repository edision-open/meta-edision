DESCRIPTION = "Hardware drivers for Edision OS mini"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osmini"

KV = "4.7.0"
SRCDATE = "20160823"

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
	install -m 0644 ${S}/lib/modules/${KV}/extra/brcmstb-osmini.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/fts260.ko ${D}${base_libdir}/modules/${KV}/extra
	install -m 0644 ${S}/lib/modules/${KV}/extra/sp988x.ko ${D}${base_libdir}/modules/${KV}/extra

	install -d ${D}${sysconfdir}/modules-load.d
	echo brcmstb-osmini >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo fts260 >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
	echo sp988x >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

SRC_URI[md5sum] = "dc43269a0af8925b47643a624406dc22"
SRC_URI[sha256sum] = "dcadeae5cb75f24f29a411de64fd023d135a04fd9794bc72c668d8410b6f3e30"
