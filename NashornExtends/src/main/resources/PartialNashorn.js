
var NashornExtendsPrinter = Java.type('com.rgc.nashorn.entity.impl.NashornExtendsPrinter');
var ExtendedClass = new (Java.extend(NashornExtendsPrinter, {
    partialPrinting: function(i) {

        /*
            MegaCustom code
         */


        print('    ->> PartialPrinting: ' + i);
    }
}));

var PartialNashorn = function(){}

PartialNashorn.prototype = {
    print: function() { ExtendedClass.print(); }
};