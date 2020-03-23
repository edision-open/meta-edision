## arm
#DEFAULTTUNE = "armv7vehf-neon-vfpv4"
#KERNEL_IMAGETYPE = "zImage"

# arm64
DEFAULTTUNE = "aarch64"
KERNEL_IMAGETYPE = "Image.gz"

require conf/machine/include/arm/arch-armv8.inc
