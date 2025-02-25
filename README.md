## Flexible Arms

A Fabric 1.21 Mod allowing adjusting arm positions in item JSON models.

This Mod Wis **Ported** To 1.21 From [This Mod](https://modrinth.com/mod/flexible-arms)
Getting Started

### DO _NOT_ REPORT ISSUES TO THE OFFICIAL REPOSITORY, THIS IS _JUST_ A FAN PORT

It's pretty simple! You just need to add a few lines into your existing JSON model files.


```
{
  // ...
  "arm_properties": {
    "held_mainhand": {
      "right_arm": { // Adjust the right arm
        "pitch": -0.95, // Any float value is valid
        "yaw": -0.39, // Here too
        "roll": 0.0,
        "follow_sight": false // Optional - Whether this arm will move according to the holder's sight (Think bows and crossbows)
      },
      "left_arm": { // Left arm too
        "pitch": -0.90,
        "yaw": 0.39,
        "roll": 0.0,
        "follow_sight": false
      }
    },
    "held_offhand": { // Also off hand
      "right_arm": { // Adjust the right arm
        "pitch": -0.95, // Any float value is valid
        "yaw": -0.39, // Here too
        "roll": 0.0,
        "follow_sight": false // Optional - Whether this arm will move according to the holder's sight (Think bows and crossbows)
      },
      "left_arm": { // Left arm too
        "pitch": -0.90,
        "yaw": 0.39,
        "roll": 0.0,
        "follow_sight": false
      }
    }
    // If any field above (except for "follow_sight") is presented,
    // the game will not try to adjust the model with vanilla mechanics.
    // You'd better configure both pitch and yaw for each arm at the same time.
  }
}
```


>    JSON does not support comments, you'll need to remove the comments before you put them into a real JSON file!

## Developers
To add Flexible Arms to your project, you need to add the modrinth maven which can be seen in more depth on how to do so [Here](https://support.modrinth.com/en/articles/8801191-modrinth-maven)

### build.gradle
```javascript
repositories {
	maven {
		name = "Modrinth"
		url = "https://api.modrinth.com/maven"
		content {
			includeGroup "maven.modrinth"
		}
	}
}
```
#### and then to add it as a dependency
```javascript
dependencies {
	modImplementation "maven.modrinth:flexible-arms-1.21:${flexible_arms_version}"
}
```
#### gradle.properties
```
flexible_arms_version=mc1.21-1.0.0
```
