module.exports = {
  apps : [
    {
      name: "scammer-spam",
      script: "app.js",
      watch: true,
      env: {
        NODE_ENV: "production",
      }
    }
  ]
}