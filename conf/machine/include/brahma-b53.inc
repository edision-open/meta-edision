# arm
DEFAULTTUNE = "armv7vehf-neon-vfpv4"
KERNEL_IMAGETYPE = "zImage"

## arm64
#DEFAULTTUNE = "aarch64"
#KERNEL_IMAGETYPE = "Image.gz"

require conf/machine/include/arm/arch-arm64.inc

BOX_BRAND = "edision"

SOC_FAMILY = "bcm72604"

MTD_BOOTFS = "mmcblk1p1"
MTD_BLACK  = "mmcblk1"
MTD_KERNEL = "mmcblk1p2"
MTD_ROOTFS = "mmcblk1p3"
KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.tar.bz2"

MACHINE_FEATURES += "HDMI"

STB_PLATFORM = "edision4k"

RCNAME = "edision3"
