SUMMARY = "Utilities for transponder & dvb-s/c blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "osmega|osmini|osminiplus"

PACKAGES = "os-blindscan-dvbs-utils os-blindscan-dvbc-utils"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_os-blindscan-dvbs-utils += "virtual/blindscan-dvbs"
RPROVIDES_os-blindscan-dvbc-utils += "virtual/blindscan-dvbc"

PV = "1.5"

SRC_URI = "https://github.com/edision-open/os-blindscan-utils/releases/download/v${PV}/os-blindscan-utils-${PV}.zip"

S = "${WORKDIR}"

FILES_os-blindscan-dvbs-utils = "${bindir}/blindscan"
FILES_os-blindscan-dvbc-utils = "${bindir}/tda1002x"

INSANE_SKIP_${PN} += "already-stripped"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tda1002x ${D}${bindir}
	install -m 0755 ${S}/blindscan ${D}${bindir}
}

SRC_URI[md5sum] = "74df88fa6bfd16c39204e6c56951d30d"
SRC_URI[sha256sum] = "3b5ecee44cdc6fdd87867a70467c38fb6a778223e6d51ffd159f176c773993d4"
