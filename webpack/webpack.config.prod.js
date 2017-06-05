const Path = require("path");
const WebpackMerge = require("webpack-merge");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");

const config = require("./webpack.config");

//Purely used during production
//Uses the base webpack.config.js and builds on top of that
module.exports = function () {
    return WebpackMerge(config(), {
        //Creates a source map so we debug production if we need to
        devtool: "source-map",

        //Creates output to static folder in Spring's resources folder so it can be packaged in with jar
        output: {
            path: Path.resolve(__dirname, "../src/main/resources/public/build"),
            publicPath: "/build/",
            filename: "bundle.js"
        },

        plugins: [
            //Uses a template index.html.ejs to create a more fully featured one
            new HtmlWebpackPlugin({
                filename: Path.resolve(__dirname, "../src/main/resources/public/index.html"),
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
                    to: "../assets"
                }
            ])
        ]
    });
};
