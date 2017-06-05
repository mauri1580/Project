export default function () {
    return function(val, range) {
        range = parseInt(range);
        for (let i = 0; i < range; i++) {
            val.push(i);
        }

        return val;
    }
}
