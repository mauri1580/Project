const Path = require("path");

module.exports = function () {
    return{
        //Entry point for the application
        entry: Path.resolve(__dirname, "../src/main/frontend/js/index.js"),

        node: {
            net: 'empty',
            tls: 'empty',
            fs: 'empty'
        },

        module: {
            //Rules dictate how things get loaded into our bundle
            rules: [
                {
                    test:  /\.js$/,
                    exclude: /node_modules/,
                    use: [
                        {
                            loader: "ng-annotate-loader"
                        },
                        {
                            loader: "babel-loader",
                            options: {
                                presets: ["es2015"]
                            }
                        }
                    ]
                },

                {
                    test: /\.html$/,
                    use: [
                        {
                            loader: "raw-loader",
                        },
                        {
                            loader: "html-minifier-loader",
                            options: {
                                empty: true
                            }
                        }
                    ]
                },

                {
                    test: /\.css$/,
                    use: [
                        {
                            loader: "style-loader"
                        },
                        {
                            loader: "css-loader"
                        }
                    ]
                },

                {
                    test: /\.(woff|eot|woff2|ttf|svg|png)(\?v=\d+\.\d+\.\d+)?$/,
                    use: [
                        {
                            loader: "url-loader",
                            query: {
                                limit: 100000
                            }
                        }
                    ]
                }
            ]
        }
    }
};
