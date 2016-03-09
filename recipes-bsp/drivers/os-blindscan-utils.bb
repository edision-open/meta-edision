SUMMARY = "Utilities for transponder & dvb-s/c blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "os-blindscan-dvbs-utils os-blindscan-dvbc-utils"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_os-blindscan-dvbs-utils += "virtual/blindscan-dvbs"
RPROVIDES_os-blindscan-dvbc-utils += "virtual/blindscan-dvbc"

SRC_URI = "file://blindscan file://tda1002x"

PV = "1.2"

S = "${WORKDIR}/"

FILES_os-blindscan-dvbs-utils = "${bindir}/blindscan"
FILES_os-blindscan-dvbc-utils = "${bindir}/tda1002x"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/${bindir}/
	install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
	install -m 0755 "${S}/blindscan" "${D}/${bindir}"
}
