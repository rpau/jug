(function($) {
	$.fn.pagination = function(options) {
		
		this.each(function(index) {
			var ul = $('<ul class="pagination col-md-offset-4"></ul>');
			var div = $('<div class="col-md-offset-4"></div>');
			$(this).append(div);
			$(div).append(ul);
			createPages(options['totalPages'], options['numPage'],
					options['onChangePage'], ul, options['params'],options['maxPages']);
		});
	};

	function createPages(totalPages, numPage, changePageFunction, elem, params, maxPages) {
		
		if (totalPages > 1) {
			var beforeRemainingPages = 5;
			var afterRemainingPages = 4;
			if(maxPages!==undefined && maxPages!==null){
			    var n = maxPages/2;
			    if(n<2){
			        var beforeRemainingPages = 1;
				    var afterRemainingPages = 1;
			    }
			    else{
			        beforeRemainingPages = Math.ceil(n);
				    afterRemainingPages = beforeRemainingPages-1;
			    }
			}
			
			var firstPage, lastPage;
			if (numPage > beforeRemainingPages) {
				firstPage = numPage - beforeRemainingPages;
			} else {
				firstPage = 1;
			}
			if (totalPages >= numPage + beforeRemainingPages) {
				lastPage = numPage + beforeRemainingPages;
			} else {
				lastPage = totalPages;
			}
			
			//First page to show
			firstPage = numPage - beforeRemainingPages;
			
			//If below 1, store difference to add it to the last page
			if(firstPage < 1){
				afterRemainingPages += 1 - firstPage;
				firstPage = 1;
			}
			
			//Last page to show
			lastPage = numPage + afterRemainingPages;
			
			//If higher than the number of pages, decrease of the first page
			if(lastPage > totalPages){
				var difference = lastPage - totalPages;
				lastPage = totalPages;
				firstPage -= Math.min(difference, (firstPage-1));
			}
			
			if (firstPage < numPage) {
			    var li = $('<li></li>');
				var link = $('<a href="#" >Previous</a>');
			
				$(link).click(function(e){
					params['page'] =  (numPage - 1);
					e.preventDefault();
					return changePageFunction.apply(e,[e,params]);
				});				
				$(li).append($(link));
				$(elem).append($(li));
			
			}

			
			for ( var i = firstPage; i < numPage; i++) {
				var li = $('<li></li>');
				var link = $('<a href="#">' + i
						+ '</a>');
				
				$(link).click(function(e){
					params['page'] =  parseInt($(this).text());
					e.preventDefault();
					return changePageFunction.apply(e,  [e, params]);
				});
				$(li).append($(link));
				$(elem).append($(li));
			
			}
			
			//Selected item
			var li = $('<li class="active"></li>');
			var link = $('<a href="#">' + numPage + '</a>');
			$(li).append($(link));
			$(elem).append($(li));
			
			
			
			for ( var i = numPage + 1; i <= lastPage; i++) {
				var li = $('<li ></li>');				
				var link = $('<a href="#" >' + i
						+ '</a>');
				$(link).bind('custom', changePageFunction);
				$(link).click(function(e){
					params['page'] =  parseInt($(this).text());
					e.preventDefault();
					return changePageFunction.apply(e, [e, params]);
				});
				$(li).append($(link));
				$(elem).append($(li));
			
			}

			if (lastPage > numPage) {
				var li = $('<li></li>');
				var link = $('<a href="#">Next</a>');
				$(link).bind('custom', changePageFunction);
				$(link).click(function(e){
					 params['page'] =   numPage + 1;
					 e.preventDefault();
					 return changePageFunction.apply(e,  [e,params] );
				});				
				$(li).append($(link));
				$(elem).append($(li));
			}
		}
	}
	
})(jQuery);