#
# BSP variables and settings specific to the meta-edision layer
#

# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

# recommended extra packages common to all edision machines
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kernel-module-rt2800usb"
MACHINE_EXTRA_RRECOMMENDS_append = " gst-plugin-dvbmediasink"
MACHINE_EXTRA_RRECOMMENDS_append = " enigma2-plugin-drivers-dvb-usb-opticombo"
MACHINE_EXTRA_RRECOMMENDS_append = " edision-splash"

# common machine features
MACHINE_FEATURES_append = " alsa wlan 3dtv switchoff osdposition hdmicec videoenhancement"
