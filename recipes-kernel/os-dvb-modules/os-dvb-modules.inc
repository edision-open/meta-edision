DESCRIPTION = "Hardware drivers for Edision ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PV = "${KV}+${SRCDATE}"
PR = "r0"

RDEPENDS_${PN} += "firmware-mn8847x"

SRC_URI = "https://github.com/open-edision/edision-driver/releases/download/${SRCDATE}/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

do_compile() {
}

do_install() {
	install -d -m 0755 ${D}/${base_libdir}/modules/${KV}/extra
	for modname in ${MODNAMES}; do
		install -m 0644 ${S}/${modname}.ko ${D}/${base_libdir}/modules/${KV}/extra/${modname}.ko
	done

	install -d -m 0755 ${D}/${sysconfdir}/modules-load.d
	for modname in ${MODNAMES}; do
		echo ${modname} >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
	done
}
