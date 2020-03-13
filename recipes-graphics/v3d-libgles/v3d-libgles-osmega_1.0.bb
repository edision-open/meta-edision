DESCRIPTION = "GLES/EGL files for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "virtual/libgles2 virtual/egl"
RPROVIDES_${PN} = "virtual/libgles2 virtual/egl"

COMPATIBLE_MACHINE = "osmega"
PR = "r1"

SRC_URI = "https://github.com/edision-open/edision-gl/releases/download/v${PV}/${BPN}-${PV}.tar.xz"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"
INSANE_SKIP_${PN} = "ldflags dev-so"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT  = "1"

do_install() {
	install -m 0755 -d ${D}${libdir}
	oe_soinstall ${S}/lib/libv3dplatform.so.${PV} ${D}${libdir}
	oe_soinstall ${S}/lib/libv3ddriver.so.${PV} ${D}${libdir}
	ln -s libv3ddriver.so.${PV} ${D}${libdir}/libEGL.so
	ln -s libv3ddriver.so.${PV} ${D}${libdir}/libGLESv2.so
	install -m 0755 -d ${D}/${includedir}
	install -m 0644 ${S}/include/v3dplatform.h ${D}${includedir}
	for d in EGL GLES GLES2 KHR; do
		install -m 0755 -d ${D}${includedir}/$d
		for f in ${S}/include/$d/*.h; do
			install -m 0644 $f ${D}${includedir}/$d
		done
	done
}

SRC_URI[md5sum] = "37f2f6cbfcfb94f290e2fef29ccbd0d8"
SRC_URI[sha256sum] = "b0bfdece79a386d86d45dd93b42b97ef67ee6989746c1d219b8acb67757551ca"
