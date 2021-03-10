#
# Common configuration for all machines of the arm64 type
#

# arm
DEFAULTTUNE = "armv7vehf-neon-vfpv4"
KERNEL_IMAGETYPE = "zImage"
require conf/machine/include/arm/arch-arm64.inc

## arm64
#DEFAULTTUNE = "aarch64"
#KERNEL_IMAGETYPE = "Image.gz"
#require conf/machine/include/arm/arch-armv8a.inc
