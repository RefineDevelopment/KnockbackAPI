rootProject.name = "KnockbackAPI"

include(":api")
include("core")
include("impl")

include("impl:imanity")
findProject(":impl:imanity")?.name = "imanity"
include("impl:foxspigot")
findProject(":impl:foxspigot")?.name = "foxspigot"
include("impl:atomspigot")
findProject(":impl:atomspigot")?.name = "atomspigot"
include("impl:vspigot")
findProject(":impl:vspigot")?.name = "vspigot"
include("impl:azurite")
findProject(":impl:azurite")?.name = "azurite"
include("impl:carbon")
findProject(":impl:carbon")?.name = "carbon"
include("impl:carbon-legacy")
findProject(":impl:carbon-legacy")?.name = "carbon-legacy"
