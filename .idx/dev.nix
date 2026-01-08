# To learn more about how to use Nix to configure your environment
# see: https://firebase.google.com/docs/studio/customize-workspace
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-24.05"; # or "unstable"

  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.jdk
    pkgs.maven
  ];

  # Sets environment variables in the workspace
  env = {};

  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"
      "redhat.java"
      "vscjava.vscode-maven"
      "vmware.vscode-boot-dev-pack"
      "gabrielbb.vscode-lombok"
    ];

    # Enable previews
    previews = {
      enable = true;
      previews = {
        web = {
          # Run the app on port $PORT and show it in the web preview
          command = ["./mvnw" "spring-boot:run" "-Dspring-boot.run.jvmArguments=-Dserver.port=$PORT"];
          manager = "web";
        };
      };
    };

    # Workspace lifecycle hooks
    workspace = {
      # Runs when a workspace is first created
      onCreate = {
        # Install dependencies with maven wrapper
        install-deps = ''
          chmod +x mvnw
          ./mvnw install
        '';
      };
    };
  };
}
