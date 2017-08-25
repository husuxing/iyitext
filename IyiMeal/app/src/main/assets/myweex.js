define('@weex-component/myweex', function (require, exports, module) {

    ;

    ;module.exports.style = {}

    ;module.exports.template = {
        "type": "div",
        "children": [
            {
                "type": "text",
                "classList": [
                    "title"
                ],
                "attr": {
                    "value": "Hello"
                }
            }
        ]
    }

    ;})

// require module
bootstrap('@weex-component/myweex', {"transformerVersion":"0.3.1"})