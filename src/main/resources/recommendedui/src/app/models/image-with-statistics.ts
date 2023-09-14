import { SafeUrl } from "@angular/platform-browser";

export class ImageWithStatistics {
    name!: string;
    image!: SafeUrl;

    statisticsMapMale: Map<string, Array<number>> = new Map<string, Array<number>>([
        ["EXTREMELY BAD", new Array<number>()],
        ["BAD", new Array<number>()],
        ["NEUTRAL", new Array<number>()],
        ["GOOD", new Array<number>()],
        ["EXTREMELY GOOD", new Array<number>()]
    ]);
    
    statisticsMapFemale: Map<string, Array<number>> = new Map<string, Array<number>>([
        ["EXTREMELY BAD", new Array<number>()],
        ["BAD", new Array<number>()],
        ["NEUTRAL", new Array<number>()],
        ["GOOD", new Array<number>()],
        ["EXTREMELY GOOD", new Array<number>()]
    ]);

    statisticsMapUnknow: Map<string, Array<number>> = new Map<string, Array<number>>([
        ["EXTREMELY BAD", new Array<number>()],
        ["BAD", new Array<number>()],
        ["NEUTRAL", new Array<number>()],
        ["GOOD", new Array<number>()],
        ["EXTREMELY GOOD", new Array<number>()]
    ]);
    constructor() { }
}