const Path = require("path");
const WebpackMerge = require("webpack-merge");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");

const config = require("./webpack.config");

//Purely used during development for fast reloading
//Uses the base webpack.config.js and builds on top of that
module.exports = function () {
    return WebpackMerge(config(), {

        //Dev server to use so you don't have to webpack then reload Spring
        devServer: {
            contentBase: Path.resolve(__dirname, ""),
            publicPath: "/",
            port: 8181,
            historyApiFallback: true,
            //Will proxy all request to the backend api endpoints
            proxy: {
                "/api": {
                    target: 'http://localhost:8080',
                    secure: false,
                    changeOrigin: true
                },
                "/management": {
                    target: 'http://localhost:8080',
                    secure: false,
                    changeOrigin: true
                }
            }
        },

        //Creates output to current directory
        //This is purely done in memory and not to disk since we use the dev server here
        output: {
            path: Path.resolve(__dirname, "build"),
            publicPath: "/",
            filename: "bundle.js"
        },

        plugins: [
            //Uses a template index.html to create a more fully featured one
            new HtmlWebpackPlugin({
                filename: "index.html",
                template: Path.resolve(__dirname, "../src/main/frontend/index.html.ejs"),
                title: "BDMS",
                inject: false,
                link: [
                    "https://ajax.googleapis.com/ajax/libs/angular_material/1.1.1/angular-material.min.css",
                    "https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic",
                    "https://fonts.googleapis.com/icon?family=Material+Icons"
                ]
            }),

            new CopyWebpackPlugin([
                {
                    from: Path.resolve(__dirname, "../src/main/frontend/assets"),
                    to: "assets"
                }
            ])
        ]
    });
};
