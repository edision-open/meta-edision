SUMMARY = "Firmware for mn8847x"
LICENSE = "CLOSED"

PACKAGE_ARCH = "all"

SRC_URI = "file://mn8847x.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 mn88472.fw ${D}${base_libdir}/firmware
	install -m 0644 mn88473.fw ${D}${base_libdir}/firmware
}
