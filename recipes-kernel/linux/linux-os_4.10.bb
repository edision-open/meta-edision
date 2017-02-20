require linux-os.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/open-edision/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "osmega|osmini|osminiplus"

SRC_URI[kernel.md5sum] = "b5e7f6b9b2fe1b6cc7bc56a3a0bfc090"
SRC_URI[kernel.sha256sum] = "3c95d9f049bd085e5c346d2c77f063b8425f191460fcd3ae9fe7e94e0477dc4b"
SRC_URI[kernelpatch.md5sum] = "1aa65d58897b628243d2fb92e34b8f3f"
SRC_URI[kernelpatch.sha256sum] = "8dc3289e9c832f00f89b11c71397cdfe8bff7abed11a32ae42b1bacac495b0fb"
