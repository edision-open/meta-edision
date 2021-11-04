SUMMARY = "Qualcomm WiFi driver for QCA module 6174"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://Android.mk;md5=235cc8d87e0fb1c956be4af0d07074fb"
CAF_MIRROR = "https://source.codeaurora.org/external/wlan"

inherit module

COMPATIBLE_MACHINE = "osmio4k|osmio4kplus"

SRC_URI = "${CAF_MIRROR}/qcacld-2.0/snapshot/qcacld-2.0-${PV}.tar.gz \
    file://qcacld-2.0-support.patch \
"

SRC_URI[md5sum] = "639660ec3ead1dc59e4ca20bfce7b4c9"
SRC_URI[sha256sum] = "870b0e762e8ee885938eaf7da9dea0b6505a40a0eae7ce8c6409b53e015faa7a"

S = "${WORKDIR}/qcacld-2.0-${PV}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${S}/wlan.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra

    install -d -m 0755 ${D}${sysconfdir}/modules-load.d
    echo wlan > ${D}${sysconfdir}/modules-load.d/wlan.conf
}

python do_package_prepend() {
    d.prependVar('PKGV', '-')
    d.prependVar('PKGV', d.getVar("KERNEL_VERSION", True).split("-")[0])
}

FILES_${PN} += "${sysconfdir}/modules-load.d/wlan.conf"
