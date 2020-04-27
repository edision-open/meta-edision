require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = "http://source.mynonpublic.com/edision/linux-edision-${PV}.tar.xz \
	file://defconfig \
	file://0002-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0003-cp1emu-do-not-use-bools-for-arithmetic.patch \
	"

COMPATIBLE_MACHINE = "osnino|osninoplus|osninopro"

SRC_URI[md5sum] = "10eb489d6d34213451ae808f55f449da"
SRC_URI[sha256sum] = "21a2db8e25d8eab13674cc45f8b102d7fa126b950648a02590daef4ff4c00f4c"
