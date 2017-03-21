 $(function () {
            $.each(province, function (k, p) {
                var option = "<option value='" + p.ProID + "'>" + p.ProName + "</option>";
                $("#province").append(option);
            });
             
            $("#province").change(function () {
                var selValue = $(this).val(); 
                $("#city option:gt(0)").remove();
                 
                $.each(city, function (k, p) { 
                    if (p.ProID == selValue) {
                        var option = "<option value='" + p.CityID + "'>" + p.CityName + "</option>";
                        $("#city").append(option);
                    }
                });
                 
            });
             
            $("#city").change(function () {
                var selValue = $(this).val();
                $("#county option:gt(0)").remove(); 

                $.each(District, function (k, p) {
                    if (p.CityID == selValue) {
                        var option = "<option value='" + p.Id + "'>" + p.DisName + "</option>";
                        $("#county").append(option);
                    }
                }); 
            }); 
        });