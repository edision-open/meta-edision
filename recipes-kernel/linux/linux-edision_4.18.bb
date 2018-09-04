require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[kernel.md5sum] = "bee5fe53ee1c3142b8f0c12c0d3348f9"
SRC_URI[kernel.sha256sum] = "19d8bcf49ef530cd4e364a45b4a22fa70714b70349c8100e7308488e26f1eaf1"
SRC_URI[kernelpatch.md5sum] = "1ffe90a396c3783d9a164b7d2a30fd80"
SRC_URI[kernelpatch.sha256sum] = "875b16b786803194bb076eaf03fde423688ea9325fc1c01197c30f3764e2688b"
