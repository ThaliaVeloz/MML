import React from 'react';
import ReactDOM from 'react-dom';
import ol from 'openlayers';
import {IntlProvider} from 'react-intl';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import AppBar from 'material-ui/AppBar';
import IconMenu from 'material-ui/IconMenu';
import MenuItem from 'material-ui/MenuItem';
import Button from 'boundless-sdk/components/Button';
import enMessages from 'boundless-sdk/locale/en';
import InfoPopup from 'boundless-sdk/components/InfoPopup';
import MapPanel from 'boundless-sdk/components/MapPanel';
import FeatureTable from 'boundless-sdk/components/FeatureTable';
import QueryBuilder from 'boundless-sdk/components/QueryBuilder';
import LayerList from 'boundless-sdk/components/LayerList';
import ImageExport from 'boundless-sdk/components/ImageExport';
import Zoom from 'boundless-sdk/components/Zoom';
import Select from 'boundless-sdk/components/Select';
import Navigation from 'boundless-sdk/components/Navigation';
import QGISPrint from 'boundless-sdk/components/QGISPrint';
import injectTapEventPlugin from 'react-tap-event-plugin';

// Needed for onTouchTap
// Can go away when react 1.0 release
// Check this repo:
// https://github.com/zilverline/react-tap-event-plugin
injectTapEventPlugin();

var defaultFill = new ol.style.Fill({
   color: 'rgba(255,255,255,0.4)'
 });
 var defaultStroke = new ol.style.Stroke({
   color: '#3399CC',
   width: 1.25
 });
 var defaultSelectionFill = new ol.style.Fill({
   color: 'rgba(255,255,0,0.4)'
 });
 var defaultSelectionStroke = new ol.style.Stroke({
   color: '#FFFF00',
   width: 1.25
 });


var patternFill_1 = new ol.style.Fill({});
var patternImg_1 = new Image();
patternImg_1.src = './data/styles/pattern1.png';
patternImg_1.onload = function() {
    var canvas = document.createElement('canvas');
    var context = canvas.getContext('2d');
    var pattern = context.createPattern(patternImg_1, 'repeat');
    patternFill_1 = new ol.style.Fill({
        color: pattern
    });
    lyr_manzana.changed()
};

var textStyleCache_manzana = {}
var clusterStyleCache_manzana = {}
var style_manzana = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(128,152,72,1.0)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(186,221,105,1.0)"
        })
    }), new ol.style.Style({
        fill: patternFill_1
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_manzana = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    }), new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_predio = {}
var clusterStyleCache_predio = {}
var style_predio = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(0,0,0,1.0)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(253,191,111,1.0)"
        })
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_predio = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_piso1 = {}
var clusterStyleCache_piso1 = {}
var style_piso1 = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(0,0,0,0.458823529412)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(233,133,150,0.458823529412)"
        })
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_piso1 = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_piso2 = {}
var clusterStyleCache_piso2 = {}
var style_piso2 = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(0,0,0,0.505882352941)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(99,184,248,0.505882352941)"
        })
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_piso2 = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_piso3 = {}
var clusterStyleCache_piso3 = {}
var style_piso3 = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(0,0,0,0.494117647059)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(30,236,236,0.494117647059)"
        })
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_piso3 = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_piso4 = {}
var clusterStyleCache_piso4 = {}
var style_piso4 = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(0,0,0,0.505882352941)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(119,120,209,0.505882352941)"
        })
    })];
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_piso4 = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        }),
        fill: new ol.style.Fill({
            color: "rgba(255, 204, 0, 1)"
        })
    })]
    var allStyles = [];

    allStyles.push.apply(allStyles, style);
    return allStyles;
};

var textStyleCache_calles_osm = {}
var clusterStyleCache_calles_osm = {}
var style_calles_osm = function(feature, resolution) {

    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(86,172,29,1.0)",
            lineDash: null,
            width: 0
        })
    })];
    var allStyles = [];

    var labelText = feature.get("name");

    var key = value + "_" + labelText;
    if (!textStyleCache_calles_osm[key]) {
        var text = new ol.style.Text({
            font: '16.5px Calibri,sans-serif',
            text: labelText,
            fill: new ol.style.Fill({
                color: "rgba(0, 0, 0, 255)"
            }),
            textBaseline: "middle",
            textAlign: "center",
            rotation: -0.0,
            offsetX: 0.0,
            offsetY: 0.0
        });
        textStyleCache_calles_osm[key] = new ol.style.Style({
            "text": text
        });
    }
    allStyles.push(textStyleCache_calles_osm[key]);

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var selectionStyle_calles_osm = function(feature, resolution) {
    var value = "";
    var style = [new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: "rgba(255, 204, 0, 1)",
            lineDash: null,
            width: 0
        })
    })]
    var allStyles = [];

    var labelText = feature.get("name");

    var key = value + "_" + labelText;
    if (!textStyleCache_calles_osm[key]) {
        var text = new ol.style.Text({
            font: '16.5px Calibri,sans-serif',
            text: labelText,
            fill: new ol.style.Fill({
                color: "rgba(0, 0, 0, 255)"
            }),
            textBaseline: "middle",
            textAlign: "center",
            rotation: -0.0,
            offsetX: 0.0,
            offsetY: 0.0
        });
        textStyleCache_calles_osm[key] = new ol.style.Style({
            "text": text
        });
    }
    allStyles.push(textStyleCache_calles_osm[key]);

    allStyles.push.apply(allStyles, style);
    return allStyles;
};
var baseLayers = [new ol.layer.Tile({
    type: 'base',
    title: 'CartoDB light',
    source: new ol.source.XYZ({
        url: 'http://s.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png',
        attributions: [new ol.Attribution({
            html: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, &copy; <a href="http://cartodb.com/attributions">CartoDB</a>'
        })]
    }),
    projection: 'EPSG:3857'
})];
var baseLayersGroup = new ol.layer.Group({
    showContent: true,
    'type': 'base-group',
    'title': 'Base maps',
    layers: baseLayers
});
var overlayLayers = [];
var overlaysGroup = new ol.layer.Group({
    showContent: true,
    'title': 'Overlays',
    layers: overlayLayers
});
var lyr_manzana = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_manzana.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 70.0001680004,

    style: style_manzana,
    selectedStyle: selectionStyle_manzana,
    title: "manzana",
    id: "manzana20170604192531185",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});
var lyr_predio = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_predio.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 2.80000672002,

    style: style_predio,
    selectedStyle: selectionStyle_predio,
    title: "predio",
    id: "predio20170604192548578",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: "<table class='popup-table'><tr><th>Attribute</th><th>Value</th><tr><td>gid</td><td style='text-align:right'>[gid]</td></tr><tr><td>provincia</td><td style='text-align:right'>[provincia]</td></tr><tr><td>canton</td><td style='text-align:right'>[canton]</td></tr><tr><td>parroquia</td><td style='text-align:right'>[parroquia]</td></tr><tr><td>zona</td><td style='text-align:right'>[zona]</td></tr><tr><td>sector</td><td style='text-align:right'>[sector]</td></tr><tr><td>manzana</td><td style='text-align:right'>[manzana]</td></tr><tr><td>predio</td><td style='text-align:right'>[predio]</td></tr><tr><td>tipo_lote</td><td style='text-align:right'>[tipo_lote]</td></tr><tr><td>propiedad_</td><td style='text-align:right'>[propiedad_]</td></tr><tr><td>derechos_a</td><td style='text-align:right'>[derechos_a]</td></tr><tr><td>clave_cata</td><td style='text-align:right'>[clave_cata]</td></tr><tr><td>propietari</td><td style='text-align:right'>[propietari]</td></tr><tr><td>area</td><td style='text-align:right'>[area]</td></tr><tr><td>perimetro</td><td style='text-align:right'>[perimetro]</td></tr><tr><td>centroide_</td><td style='text-align:right'>[centroide_]</td></tr><tr><td>centroid00</td><td style='text-align:right'>[centroid00]</td></tr><tr><td>centroid01</td><td style='text-align:right'>[centroid01]</td></tr><tr><td>centroid02</td><td style='text-align:right'>[centroid02]</td></tr><tr><td>fotografia</td><td style='text-align:right'>[fotografia]</td></tr><tr><td>html</td><td style='text-align:right'>[html]</td></tr><tr><td>id_predio</td><td style='text-align:right'>[id_predio]</td></tr><tr><td>id_manzsig</td><td style='text-align:right'>[id_manzsig]</td></tr><tr><td>vinculado</td><td style='text-align:right'>[vinculado]</td></tr><tr><td>ts_fecha_creacion</td><td style='text-align:right'>[ts_fecha_creacion]</td></tr><tr><td>ts_fecha_actualizacion</td><td style='text-align:right'>[ts_fecha_actualizacion]</td></tr><tr><td>id_session_usuario</td><td style='text-align:right'>[id_session_usuario]</td></tr></table>"
});
var lyr_piso1 = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_piso1.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 1.40000336001,

    style: style_piso1,
    selectedStyle: selectionStyle_piso1,
    title: "piso1",
    id: "piso120170604192620945",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});
var lyr_piso2 = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_piso2.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 1.40000336001,

    style: style_piso2,
    selectedStyle: selectionStyle_piso2,
    title: "piso2",
    id: "piso220170604192622926",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});
var lyr_piso3 = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_piso3.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 1.40000336001,

    style: style_piso3,
    selectedStyle: selectionStyle_piso3,
    title: "piso3",
    id: "piso320170604192625606",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});
var lyr_piso4 = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_piso4.json'
    }),

    minResolution: 0.000280000672002,
    maxResolution: 1.40000336001,

    style: style_piso4,
    selectedStyle: selectionStyle_piso4,
    title: "piso4",
    id: "piso420170604192626973",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});
var lyr_calles_osm = new ol.layer.Vector({
    opacity: 1.0,
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: './data/lyr_calles_osm.json'
    }),

    style: style_calles_osm,
    selectedStyle: selectionStyle_calles_osm,
    title: "calles_osm",
    id: "calles_osm20170604192657307",
    filters: [],
    timeInfo: null,
    isSelectable: true,
    popupInfo: ""
});

lyr_manzana.setVisible(true);
lyr_predio.setVisible(true);
lyr_piso1.setVisible(true);
lyr_piso2.setVisible(true);
lyr_piso3.setVisible(true);
lyr_piso4.setVisible(true);
lyr_calles_osm.setVisible(true);
for (var i = 0; i < baseLayers.length; i++) {
    baseLayers[i].setVisible(false);
}
baseLayers[0].setVisible(true);
var layersList = [lyr_manzana, lyr_predio, lyr_piso1, lyr_piso2, lyr_piso3, lyr_piso4, lyr_calles_osm];
layersList.unshift(baseLayersGroup);
var printLayouts = [{
    "width": 210.0,
    "elements": [{
        "name": "PRIMERA IMPRESION",
        "height": 13.921140472360975,
        "width": 150.78063273072286,
        "y": 20.73184270733738,
        "x": 27.953433634638515,
        "font": "MS Shell Dlg 2",
        "type": "label",
        "id": "31398940-a004-44d3-87c0-6deff6eea8d1",
        "size": 36
    }, {
        "height": 293.11707317073166,
        "width": 192.25914634146346,
        "grid": {
            "intervalX": 0.0,
            "intervalY": 0.0,
            "annotationEnabled": false,
            "crs": ""
        },
        "y": 3.882926829268292,
        "x": 8.870426829268268,
        "type": "map",
        "id": "b79217b3-ddbe-4a2b-af16-619d32af908c"
    }, {
        "height": 292.8170731707317,
        "width": 198.6216463414633,
        "y": 4.032926829268292,
        "x": 4.032926829268292,
        "type": "shape",
        "id": "f3ffac70-1507-4e9d-b28d-a5f127bbd082"
    }],
    "thumbnail": "catastropredios_thumbnail.png",
    "name": "CatastroPredios",
    "height": 297.0
}];
var view = new ol.View({
    maxZoom: 32,
    minZoom: 1,
    projection: 'EPSG:32718'
});
var originalExtent = [185481.861924, 9896657.753843, 190174.228746, 9901127.280993];

var map = new ol.Map({
  layers: layersList,
  view: view,
  controls: []
});



class BasicApp extends React.Component {
  getChildContext() {
    return {
      muiTheme: getMuiTheme()
    };
  }
  componentDidMount() {
    
  }
  _toggle(el) {
    if (el.style.display === 'block') {
      el.style.display = 'none';
    } else {
      el.style.display = 'block';
    }
  }
  _toggleTable() {
    this._toggle(document.getElementById('table-panel'));
    this.refs.table.getWrappedInstance().setDimensionsOnState();
  }
  _toggleWFST() {
    this._toggle(document.getElementById('wfst'));
  }
  _toggleQuery() {
    this._toggle(document.getElementById('query-panel'));
  }
  _toggleEdit() {
    this._toggle(document.getElementById('edit-tool-panel'));
  }
  _toggleAboutPanel() {
    this._toggle(document.getElementById('about-panel'));
  }
  _toggleChartPanel(evt) {
    evt.preventDefault();
    this._toggle(document.getElementById('chart-panel'));
  }
  render() {
    var toolbarOptions = {style:{height: 71}, title:"Catastro"};
    return React.createElement("article", null,
       React.createElement(AppBar, toolbarOptions ,React.createElement(Button, {label: 'Table', onTouchTap: this._toggleTable.bind(this)}),
React.createElement(Button, {label: 'Query', onTouchTap: this._toggleQuery.bind(this)}),
React.createElement(ImageExport, {map:map}),
React.createElement(Select, {toggleGroup: 'navigation', map:map}),
React.createElement(Navigation, {toggleGroup: 'navigation', secondary: true}),
React.createElement(QGISPrint, {map:map, layouts:printLayouts, thumbnailPath: './resources/print/',})
       ),
      React.createElement("div", {id: 'content'},
        React.createElement(MapPanel, {id: 'map', map: map, extent: originalExtent, useHistory: true}
          ,
React.createElement("div", {id: 'query-panel', className:'query-panel'},
                                          React.createElement(QueryBuilder, {map: map})
                                        ),
React.createElement("div", {id: 'popup', className: 'ol-popup'},
                                    React.createElement(InfoPopup, {map: map, hover: false})
                                  )
        )
        ,
 React.createElement("div", {id: 'table-panel', className: 'attributes-table'},
                                          React.createElement(FeatureTable, {ref: 'table', pointZoom:16, map: map})
                                    ),
React.createElement("div",{id: "layerlist"},
                                    React.createElement(LayerList, {showOpacity:false, showDownload:false,
                                        showGroupContent:true, showZoomTo:false, allowReordering:false,
                                        allowFiltering:true, tipLabel:'layers',
                                        downloadFormat:'GeoJSON', map:map})),
React.createElement("div", {id:'zoom-buttons'},
                                    React.createElement(Zoom, {
                                    duration:250,
                                    zoomInTipLabel: 'Zoom in',
                                    zoomOutTipLabel: 'Zoom out',
                                    delta: 1.2,
                                    map: map})
                                  )
      )
    );
  }
}

BasicApp.childContextTypes = {
  muiTheme: React.PropTypes.object
};

ReactDOM.render(<IntlProvider locale='en' messages={enMessages}><BasicApp /></IntlProvider>, document.getElementById('main'));
