USE [INDOPLAT_190315]
GO

/****** Object:  Table [dbo].[IPP_MOBILE_SHOPFLOORHEADER]    Script Date: 05/29/2019 09:23:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[IPP_MOBILE_SHOPFLOORHEADER](
	[docEntry] [int] IDENTITY(1,1) NOT NULL,
	[id] [int] NOT NULL,
	[docNum] [nvarchar](50) NULL,
	[docDate] [datetime] NULL,
	[prodNo] [nvarchar](50) NULL,
	[prodCode] [nvarchar](50) NULL,
	[prodName] [nvarchar](254) NULL,
	[prodPlanQty] [numeric](19, 6) NULL,
	[prodStatus] [nvarchar](50) NULL,
	[routeCode] [nvarchar](50) NULL,
	[routeName] [nvarchar](254) NULL,
	[sequence] [nvarchar](50) NULL,
	[sequenceQty] [numeric](19, 6) NULL,
	[shift] [nvarchar](50) NULL,
	[shiftName] [nvarchar](50) NULL,
	[tanggalMulai] [datetime] NULL,
	[tanggalSelesai] [datetime] NULL,
	[jamMulai] [nvarchar](50) NULL,
	[jamSelesai] [nvarchar](50) NULL,
	[inQty] [numeric](19, 6) NULL,
	[outQty] [numeric](19, 6) NULL,
	[remarks] [nvarchar](max) NULL,
	[userId] [nvarchar](50) NULL,
	[mobileId] [nvarchar](max) NULL,
	[posted] [int] NULL,
	[TargetEntry] [int] NULL,
	[UploadTime] [datetime] NULL,
	[workCenter] [nvarchar](50) NULL,
	[status] [nvarchar](50) NULL
) ON [PRIMARY]

Go
