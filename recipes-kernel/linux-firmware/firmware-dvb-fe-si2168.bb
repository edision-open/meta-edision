SUMMARY = "Firmware for si2168"
LICENSE = "CLOSED"

PACKAGE_ARCH = "all"

PR = "r0"

SRC_URI = "file://firmware-si2168.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"

FILES_${PN} += "${base_libdir}/firmware"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 dvb-demod-si2168-a20-01.fw ${D}${base_libdir}/firmware
	install -m 0644 dvb-demod-si2168-a30-01.fw ${D}${base_libdir}/firmware
	install -m 0644 dvb-demod-si2168-b40-01.fw ${D}${base_libdir}/firmware
	install -m 0644 dvb-tuner-si2158-a20-01.fw ${D}${base_libdir}/firmware
}
