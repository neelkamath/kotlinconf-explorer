# Contributing

## Installation

1. Install a [Java JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).
1. Clone the repository using one of the following methods.
    - SSH: `git clone git@github.com:neelkamath/kotlinconf-explorer.git`
    - HTTPS: `git clone https://github.com/neelkamath/kotlinconf-explorer.git`
    
## Usage

Replace <GRADLE> with `gradlew` on Windows, and `./gradlew` on others.

### Developing

```
<GRADLE> -t run
```
Opens http://localhost:8080/ with live reload.

### Production

```
`<GRADLE> browserProductionWebpack`
```
Creates the production build in `build/distributions/`.